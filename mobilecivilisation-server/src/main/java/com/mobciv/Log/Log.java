package com.mobciv.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class Log {
	
	private class LoggerWriter extends PrintWriter {

		public LoggerWriter(File file, String csn)
				throws FileNotFoundException, UnsupportedEncodingException {
			super(file, csn);
		}

		public LoggerWriter(File file) throws FileNotFoundException {
			super(file);
		}

		public LoggerWriter(OutputStream out, boolean autoFlush) {
			super(out, autoFlush);
		}

		public LoggerWriter(OutputStream out) {
			super(out);
		}

		public LoggerWriter(String fileName, String csn)
				throws FileNotFoundException, UnsupportedEncodingException {
			super(fileName, csn);
		}

		public LoggerWriter(String fileName) throws FileNotFoundException {
			super(fileName);
		}

		public LoggerWriter(Writer out, boolean autoFlush) {
			super(out, autoFlush);
		}

		public LoggerWriter(Writer out) {
			super(out);
		}
		
		@Override
		public void println(Object x) {
			System.out.println(x);
			super.println(x);
		}
		
		@Override
		public void println(String x) {
			System.out.println(x);
			super.println(x);
		}
		
		@Override
		public void close() {
			println(DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ENGLISH).format(new Date(System.currentTimeMillis())) + " |\t| " + "Logger" +"\t| " + "Finishing");
			super.close();
		}
		
	}

	private static Log logger;
	
	private PrintWriter writer;	
	
	private Log() {
		try {
			File f = new File("Log"
					+ new SimpleDateFormat("yyyyMMdd-kkmmss").format(new Date(
							System.currentTimeMillis())) + ".log");
			if (!f.exists()) {
				f.createNewFile();
			}			
			writer = new LoggerWriter(f);	
			moveToEnd();
			log("Logger", "Start logging to file " + f.getAbsolutePath());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void moveToEnd() {
		
		
	}

	public static Log logger() {
		if (logger == null) {
			logger = new Log();
		}
		return logger;
	}
	
	public PrintWriter getPrintWriter() {
		return writer;
	}
	
	public void log(String tag, String message) {
		writer.println(DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.ENGLISH).format(new Date(System.currentTimeMillis())) + " |\t| " + tag +"\t| " + message);
	}	
	
	@Override
	protected void finalize() throws Throwable {
		writer.close();
		super.finalize();
	}

	public void close() {
		writer.close();
	}
	
}
