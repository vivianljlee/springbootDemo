package com.estar.util;

import java.util.concurrent.LinkedBlockingQueue;

public class FileNamesCache {

	private static LinkedBlockingQueue<String> filenamesqueue = new LinkedBlockingQueue<String>();

	private static FileNamesCache instance = new FileNamesCache();

	private FileNamesCache() {
	}

	public static FileNamesCache getInstance() {

		return instance;

	}

	public void addFileName(String filename) {

		filenamesqueue.add(filename);

	}

	public boolean isEmpty() {

		return filenamesqueue.isEmpty();

	}

	public String getFileName() {

		return filenamesqueue.poll();

	}

}
