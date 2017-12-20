package com.soogle.jbatch.writer_retry;

import java.io.Serializable;

import javax.batch.api.chunk.ItemReader;

public class SampleReader implements ItemReader {

	private int counter = 1;

	@Override
	public Serializable checkpointInfo() throws Exception {
		System.out.println("[Reader] checkpointInfo.");
		return counter;
	}

	@Override
	public void close() throws Exception {
		System.out.println("[Reader] close");
	}

	@Override
	public void open(Serializable arg0) throws Exception {
		// checkpointInfoの戻りになっているコミット済みのカウンターまで戻す
		// リトライ時の開始位置を正しく特定するために必要な処理
		// ファイルであればcounterは行番号に対応するはず
		System.out.println("[Reader] open");
		if (arg0 != null) {
			counter = (int) arg0;
		}
	}

	@Override
	public Object readItem() throws Exception {
		// 10まで返す
		if (counter > 10) {
			return null;
		}

		System.out.println("[Reader] readItem: " + String.valueOf(counter));
		return counter++;
	}

}
