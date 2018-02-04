package com.gk.anagram.repository;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.gk.anagram.exception.ResourceException;

@Component
public class FileRepository implements Repository {

	@Value(value="${filePath}")
	private String filePath;

	@Override
	public List<String> load() {
		List<String> wordsList = new ArrayList<>();
		try {
			wordsList = Files.lines(getPath()).collect(Collectors.toList());
		} catch (Exception e) {
			throw new ResourceException(String.format("Unable to read the content of the provided file %s", filePath));
		}
		return wordsList;
	}

	private Path getPath() throws URISyntaxException {
		URL resource = getClass().getResource(filePath);

		if (resource == null) {
			throw new ResourceException(String.format("Unable to locate the provided file %s", filePath));
		}

		Path path = Paths.get(resource.toURI());
		return path;
	}

	public static void main(String args[]) {
		//FileRepository repo = new FileRepository("/data/wordlist-small.txt");
		FileRepository repo = new FileRepository();
		repo.load();
	}
}
