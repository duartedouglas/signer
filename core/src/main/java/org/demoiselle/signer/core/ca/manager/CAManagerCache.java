package org.demoiselle.signer.core.ca.manager;

import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
	
public class CAManagerCache {
	    private static CAManagerCache instance;
	    private Map<String, Collection<X509Certificate>> cachedCertificates = new HashMap<>();
		    
	    private CAManagerCache() {
	    }
	
	    public static CAManagerCache getInstance() {
	        if (instance == null) {
	            instance = new CAManagerCache();
	        } 
	        return instance;
	    }
	
	    public Collection<X509Certificate> getCachedCertificatesFor(X509Certificate certificate) {
		    String chave = certificate.getSerialNumber().toString();
	        Collection<X509Certificate> certificates = cachedCertificates.get(chave);
	        return certificates;
	    }
	
	    public synchronized void addCertificate(X509Certificate certificate, Collection<X509Certificate> certificates) {
	        String chave = certificate.getSerialNumber().toString();
	        cachedCertificates.put(chave, certificates);	
	    }
}