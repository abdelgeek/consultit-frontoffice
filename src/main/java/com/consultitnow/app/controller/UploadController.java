package com.consultitnow.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.consultitnow.app.service.StorageService;
import com.consultitnow.model.Result;

@RestController
public class UploadController {

	@Autowired
	private StorageService storageService;

	@PostMapping("/api/uploadFile")
	public Result uploadFile(@RequestParam("file") MultipartFile file) {

		return storageService.store(file);
	}

	/*
	 * @GetMapping("/getallfiles") public ResponseEntity<List<String>>
	 * getListFiles(Model model) { List<String> fileNames = files
	 * .stream().map(fileName -> MvcUriComponentsBuilder
	 * .fromMethodName(UploadController.class, "getFile",
	 * fileName).build().toString()) .collect(Collectors.toList());
	 * 
	 * return ResponseEntity.ok().body(fileNames); }
	 * 
	 * @GetMapping("/files/{filename:.+}")
	 * 
	 * @ResponseBody public ResponseEntity<Resource> getFile(@PathVariable
	 * String filename) { Resource file = storageService.loadFile(filename);
	 * return ResponseEntity.ok() .header(HttpHeaders.CONTENT_DISPOSITION,
	 * "attachment; filename=\"" + file.getFilename() + "\"") .body(file); }
	 */
}
