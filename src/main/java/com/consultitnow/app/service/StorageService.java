package com.consultitnow.app.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Calendar;

import org.apache.commons.io.FilenameUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.consultitnow.model.Result;

@Service
public class StorageService {

	private final Path rootLocation = Paths.get("src/main/resources/static/upload-dir");

	public Result store(MultipartFile file) {

		Result result = new Result();
		result.setIsValid(false);
		result.setMessage("FAIL to upload " + file.getOriginalFilename() + "!");
		String[] listExtensions = { "docx", "doc", "pdf" };
		Path dataSheetUrl;
		try {

			Long size = file.getSize() / 1024;
			String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());

			if (size <= 500) {

				if (Arrays.asList(listExtensions).contains(fileExtension)) {

					int y = Calendar.getInstance().get(Calendar.YEAR);
					int d = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
					int m = Calendar.getInstance().get(Calendar.MONTH);
					int h = Calendar.getInstance().get(Calendar.HOUR);
					int min = Calendar.getInstance().get(Calendar.MINUTE);
					int sec = Calendar.getInstance().get(Calendar.SECOND);
					long millis = System.currentTimeMillis() % 1000;

					String newFileName = y + "" + "" + d + "" + m + "" + h + "" + min + "" + sec + "" + millis + ""
							+ "." + fileExtension;

					Files.copy(file.getInputStream(), this.rootLocation.resolve(newFileName));
					dataSheetUrl = Paths.get(rootLocation + "/" + newFileName);
					result.setIsValid(true);
					result.setMessage(dataSheetUrl.toString());

				} else {
					result.setMessage(
							"The file Extension is not allowed! Please download a.pdf, .doc or .docx file which "
									+ "size is less than or equal 500 KB)");
				}
			} else {
				result.setMessage("The file size exceeds the configured maximum (500 KB)");
			}
		} catch (Exception e) {
			result.setMessage(e.getMessage());
		}

		return result;
	}

	public Resource loadFile(String filename) {
		try {
			Path file = rootLocation.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("FAIL!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("FAIL!");
		}
	}

	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	public void init() {

		try {
			if (!Files.exists(rootLocation)) {
				Files.createDirectory(rootLocation);
			}

		} catch (IOException e) {
			throw new RuntimeException("Could not initialize storage!");
		}

	}

}
