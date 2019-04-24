package com.wx.wxweb.tool;

import org.apache.shiro.crypto.hash.SimpleHash;

public enum PwdEncoder {

  MD5("MD5");
  
  String hashAlgorithmName = "";
  
  PwdEncoder(String algorithm){
	  hashAlgorithmName  = algorithm;
  }
  
  public String encoderPassword(Object crdentials,Object salt, int hashIterations ){
	  return new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations).toBase64();
  }
}
