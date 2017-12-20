package com.soogle.jbatch.writer_retry;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.batch.api.chunk.ItemWriter;

public class SampleWriter implements ItemWriter {
	
	private int retryCount = 0;
	
	@Override
	public Serializable checkpointInfo() throws Exception {
		System.out.println("[Writer] checkpointInfo.");
		return null;
	}

	@Override
	public void close() throws Exception {
		System.out.println("[Writer] close");
	}

	@Override
	public void open(Serializable arg0) throws Exception {
		System.out.println("[Writer] open");		
	}

	@Override
	public void writeItems(List<Object> arg0) throws Exception {
		List<String> items = arg0.stream().map(String::valueOf).collect(Collectors.toList());
		if (items.contains("7") && ++retryCount <= 3) {
			throw new RuntimeException("ItemWriterで例外発生。retryCount: " + retryCount);
		}
		System.out.println("[Writer] writeItems: " + String.join(",", items));
	}
}
