package ruxing.demo.util;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;

/**
 * Created by suclogger on 2016/8/25.
 */
public class AESUtil {

    private static Logger LOG = LoggerFactory.getLogger(AESUtil.class);

    private static final String CBCIV = "0102030405060708";

    private static final String DEFAULT_KEY = "hr@maihaoche.com";

    private static final BASE64Encoder base64Encoder = new BASE64Encoder();
    private static final BASE64Decoder base64Decoder = new BASE64Decoder();

    // 加密
    public static String encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            LOG.warn("aes加密 - Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            LOG.warn("aes加密 - Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("UTF-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        //"算法/模式/补码方式"
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        //使用CBC模式，需要一个向量iv，可增加加密算法的强度
        IvParameterSpec iv = new IvParameterSpec(CBCIV.getBytes("UTF-8"));
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("UTF-8"));
        //此处使用BASE64做转码功能，同时能起到2次加密的作用。
        return base64Encoder.encode(encrypted);
    }

    // 解密
    public static String decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                LOG.warn("aes解密 - Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                LOG.warn("aes解密 - Key长度不是16位");
                return null;
            }
            if (StringUtils.isNumeric(sSrc)) {
                LOG.warn("aes解密 - 解密的字符不能是数字");
                return null;
            }
            byte[] raw = sKey.getBytes("ASCII");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            // Cipher不是线程安全的,需要每次实例化一个
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec iv = new IvParameterSpec(CBCIV.getBytes("UTF-8"));
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            //先用base64解密
//            byte[] encrypted1 = base64Decoder.decodeBuffer(sSrc);
            // Base64 可以兼容原有的方式
            byte[] encrypted1 = Base64.decodeBase64(sSrc);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                return new String(original, "UTF-8");
            } catch (IllegalBlockSizeException e) {
                LOG.error("aes解密异常-字符长度不符合" + encrypted1);
            } catch (BadPaddingException e) {
                LOG.error("aes解密异常-密钥不匹配" + encrypted1);
            } catch (UnsupportedEncodingException e) {
                LOG.error("aes解密异常-不支持对应的加密方式" + encrypted1);
            }
            return null;
        } catch (Exception ex) {
            LOG.error("aes解密异常 - {}", ex);
            return null;
        }
    }


    /**
     * 使用默认密钥加密
     * @param sSrc
     * @return
     * @throws Exception
     */
    public static String encrypt(String sSrc){
        String result = "";
        try {
            result = encrypt(sSrc, DEFAULT_KEY);
        } catch (Exception e) {
            LOG.error("aes encrypt error", e);
        }
        return result;
    }

    /**
     * 使用默认密钥加密
     * @param sSrc
     * @return
     * @throws Exception
     */
    public static String encryptForUrl(String sSrc){
        String result = "";
        try {
            result = encrypt(sSrc, DEFAULT_KEY);
            if(!StringUtils.isBlank(result)) {
                result = result.replace("+", "-").replace("/", "_");
            }
        } catch (Exception e) {
            LOG.error("aes encrypt error", e);
        }
        return result;
    }

    /**
     * 使用默认密钥解密
     * @param sSrc
     * @return
     * @throws Exception
     */
    public static String decrypt(String sSrc){
        String result = "";
        try {
            result = decrypt(sSrc, DEFAULT_KEY);
        } catch (Exception e) {
            LOG.error("aes encrypt error", e);
        }
        return result;
    }

    /**
     * 使用默认密钥解密
     * @param sSrc
     * @return
     * @throws Exception
     */
    public static String decryptFromUrl(String sSrc){
        String result = "";
        try {
            if(!StringUtils.isBlank(sSrc)) {
                sSrc = sSrc.replace("_", "/").replace("-", "+");
                result = decrypt(sSrc, DEFAULT_KEY);
            }
        } catch (Exception e) {
            LOG.error("aes encrypt error", e);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print(AESUtil.encryptForUrl("1288"));
    }
}
