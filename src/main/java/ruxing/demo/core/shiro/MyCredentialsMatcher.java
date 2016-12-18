package ruxing.demo.core.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * Created by ruxing on 12/12/2016.
 */
public class MyCredentialsMatcher implements CredentialsMatcher {

    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        if (new String((char[]) token.getCredentials()).equals(info.getCredentials().toString())) {
            return true;
        }
        return false;
    }

}
