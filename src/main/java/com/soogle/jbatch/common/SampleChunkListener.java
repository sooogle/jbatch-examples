package com.soogle.jbatch.common;

import javax.batch.api.chunk.listener.ChunkListener;

public class SampleChunkListener implements ChunkListener {

	@Override
	public void beforeChunk() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterChunk() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(Exception arg0) throws Exception {
		System.out.println("ChunkListenerで例外を補足しました。" + arg0.getMessage());
	}

}
