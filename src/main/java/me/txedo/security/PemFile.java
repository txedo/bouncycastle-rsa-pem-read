package me.txedo.security;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.bouncycastle.util.io.pem.PemWriter;

public class PemFile {

	private PemObject pemObject;

	public PemFile(String filename) throws FileNotFoundException, IOException {
		PemReader pemReader = new PemReader(new InputStreamReader(
				new FileInputStream(filename)));
		try {
			this.pemObject = pemReader.readPemObject();
		} finally {
			pemReader.close();
		}
	}

	public void write(String filename) throws FileNotFoundException,
			IOException {
		PemWriter pemWriter = new PemWriter(new OutputStreamWriter(
				new FileOutputStream(filename)));
		try {
			pemWriter.writeObject(this.pemObject);
		} finally {
			pemWriter.close();
		}
	}

	public PemObject getPemObject() {
		return pemObject;
	}

}
