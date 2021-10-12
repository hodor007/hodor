package com.zp.zky.opc;

import java.io.File;
import java.security.KeyPair;
import java.security.cert.X509Certificate;

/**
 * @author zhengpeng
 * @ClassName CerLoad
 * @Description TODO
 * @date 2021年09月16日 10:42
 */
public interface CerLoad {

    public X509Certificate getCer(File cerfile);

    public KeyPair getKeyPair(File pkfile);

}
