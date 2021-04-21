/*
 * Copyright (c) 2021, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.wso2.carbon.identity.keyrotation.dao;

/**
 * This class holds DB related constants.
 */
public class DBConstants {

    public static final int CHUNK_SIZE = 2;
    public static final String YES = "YES";
    public static final String NO = "NO";
    public static final String CREDENTIAL = "Credential";
    public static final String REQUEST = "REQUEST";
    public static final String POSTGRESQL = "PostgreSQL";
    public static final String MSSQL = "SQL Server";
    public static final String ORACLE = "Oracle";
    public static final String SECRET_KEY = "http://wso2.org/claims/identity/secretkey";
    public static final String VERIFIED_SECRET_KEY = "http://wso2.org/claims/identity/verifySecretkey";
    public static final String GET_TOTP_SECRET = "SELECT TENANT_ID, USER_NAME, DATA_KEY, DATA_VALUE " +
            "FROM IDN_IDENTITY_USER_DATA WHERE DATA_KEY=? OR DATA_KEY=? ORDER BY TENANT_ID, USER_NAME, DATA_KEY LIMIT" +
            " ?, ?";
    public static final String GET_TOTP_SECRET_POSTGRE = "SELECT TENANT_ID, USER_NAME, DATA_VALUE, DATA_KEY FROM " +
            "IDN_IDENTITY_USER_DATA WHERE DATA_KEY=? OR DATA_KEY=? ORDER BY TENANT_ID, USER_NAME, DATA_KEY LIMIT ? " +
            "OFFSET ?";
    public static final String GET_TOTP_SECRET_OTHER = "SELECT TENANT_ID, USER_NAME, DATA_VALUE, DATA_KEY FROM " +
            "IDN_IDENTITY_USER_DATA WHERE DATA_KEY=? OR DATA_KEY=? ORDER BY TENANT_ID, USER_NAME, DATA_KEY OFFSET ? " +
            "ROWS FETCH NEXT ? ROWS ONLY";
    public static final String UPDATE_TOTP_SECRET =
            "UPDATE IDN_IDENTITY_USER_DATA SET DATA_VALUE=? WHERE TENANT_ID=? AND USER_NAME=? AND DATA_KEY=?";
    public static final String GET_TEMP_TOTP_SECRET = "SELECT TENANT_ID, USER_NAME, DATA_KEY, DATA_VALUE, " +
            "AVAILABILITY FROM IDN_IDENTITY_USER_DATA_TEMP ORDER BY SYNC_ID LIMIT ?, ?";
    public static final String GET_TEMP_TOTP_SECRET_POSTGRE = "SELECT TENANT_ID, USER_NAME, DATA_KEY, DATA_VALUE " +
            "AVAILABILITY FROM IDN_IDENTITY_USER_DATA_TEMP ORDER BY SYNC_ID LIMIT ? OFFSET ?";
    public static final String GET_TEMP_TOTP_SECRET_OTHER = "SELECT TENANT_ID, USER_NAME, DATA_KEY, DATA_VALUE " +
            "AVAILABILITY FROM IDN_IDENTITY_USER_DATA_TEMP ORDER BY SYNC_ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    public static final String INSERT_TOTP_SECRET =
            "INSERT INTO IDN_IDENTITY_USER_DATA (TENANT_ID, USER_NAME, DATA_KEY, DATA_VALUE) VALUES (?, ?, ?, ?) ON " +
                    "DUPLICATE KEY UPDATE DATA_VALUE=?";
    public static final String DELETE_TOTP_SECRET =
            "DELETE FROM IDN_IDENTITY_USER_DATA WHERE TENANT_ID=? AND USER_NAME=? AND DATA_KEY=?";
    public static final String GET_OAUTH_AUTHORIZATION_CODE =
            "SELECT CODE_ID, AUTHORIZATION_CODE, CONSUMER_KEY_ID FROM IDN_OAUTH2_AUTHORIZATION_CODE " +
                    "ORDER BY CODE_ID LIMIT ?, ?";
    public static final String GET_OAUTH_AUTHORIZATION_CODE_POSTGRE =
            "SELECT CODE_ID, AUTHORIZATION_CODE, CONSUMER_KEY_ID FROM IDN_OAUTH2_AUTHORIZATION_CODE ORDER BY " +
                    "CODE_ID LIMIT ? OFFSET ?";
    public static final String GET_OAUTH_AUTHORIZATION_CODE_OTHER =
            "SELECT CODE_ID, AUTHORIZATION_CODE, CONSUMER_KEY_ID FROM IDN_OAUTH2_AUTHORIZATION_CODE ORDER BY " +
                    "CODE_ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    public static final String UPDATE_OAUTH_AUTHORIZATION_CODE =
            "UPDATE IDN_OAUTH2_AUTHORIZATION_CODE SET AUTHORIZATION_CODE=? WHERE CODE_ID=?";
    public static final String GET_TEMP_OAUTH_AUTHORIZATION_CODE = "SELECT CODE_ID, AUTHORIZATION_CODE, " +
            "CONSUMER_KEY_ID, CALLBACK_URL, SCOPE, AUTHZ_USER, TENANT_ID, USER_DOMAIN, TIME_CREATED, " +
            "VALIDITY_PERIOD, STATE, TOKEN_ID, SUBJECT_IDENTIFIER, PKCE_CODE_CHALLENGE, PKCE_CODE_CHALLENGE_METHOD, " +
            "AUTHORIZATION_CODE_HASH, IDP_ID, AVAILABILITY FROM IDN_OAUTH2_AUTHORIZATION_CODE_TEMP ORDER BY SYNC_ID " +
            "LIMIT ?, ?";
    public static final String GET_TEMP_OAUTH_AUTHORIZATION_CODE_POSTGRE = "SELECT CODE_ID, AUTHORIZATION_CODE, " +
            "CONSUMER_KEY_ID, CALLBACK_URL, SCOPE, AUTHZ_USER, TENANT_ID, USER_DOMAIN, TIME_CREATED, " +
            "VALIDITY_PERIOD, STATE, TOKEN_ID, SUBJECT_IDENTIFIER, PKCE_CODE_CHALLENGE, PKCE_CODE_CHALLENGE_METHOD, " +
            "AUTHORIZATION_CODE_HASH, IDP_ID, AVAILABILITY FROM IDN_OAUTH2_AUTHORIZATION_CODE_TEMP ORDER BY SYNC_ID " +
            "LIMIT ? OFFSET ?";
    public static final String GET_TEMP_OAUTH_AUTHORIZATION_CODE_OTHER = "SELECT CODE_ID, AUTHORIZATION_CODE, " +
            "CONSUMER_KEY_ID, CALLBACK_URL, SCOPE, AUTHZ_USER, TENANT_ID, USER_DOMAIN, TIME_CREATED, " +
            "VALIDITY_PERIOD, STATE, TOKEN_ID, SUBJECT_IDENTIFIER, PKCE_CODE_CHALLENGE, PKCE_CODE_CHALLENGE_METHOD, " +
            "AUTHORIZATION_CODE_HASH, IDP_ID, AVAILABILITY FROM IDN_OAUTH2_AUTHORIZATION_CODE_TEMP ORDER BY SYNC_ID " +
            "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    public static final String INSERT_OAUTH_AUTHORIZATION_CODE =
            "INSERT INTO IDN_OAUTH2_AUTHORIZATION_CODE (CODE_ID, AUTHORIZATION_CODE, CONSUMER_KEY_ID, CALLBACK_URL, " +
                    "SCOPE, AUTHZ_USER, TENANT_ID, USER_DOMAIN, TIME_CREATED, VALIDITY_PERIOD, STATE, TOKEN_ID, " +
                    "SUBJECT_IDENTIFIER, PKCE_CODE_CHALLENGE, PKCE_CODE_CHALLENGE_METHOD, AUTHORIZATION_CODE_HASH, " +
                    "IDP_ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE " +
                    "AUTHORIZATION_CODE=?, CONSUMER_KEY_ID=?, CALLBACK_URL=?, SCOPE=?, AUTHZ_USER=?, TENANT_ID=?, " +
                    "USER_DOMAIN=?, TIME_CREATED=?, VALIDITY_PERIOD=?, STATE=?, TOKEN_ID=?, SUBJECT_IDENTIFIER=?, " +
                    "PKCE_CODE_CHALLENGE=?, PKCE_CODE_CHALLENGE_METHOD=?, AUTHORIZATION_CODE_HASH=?, IDP_ID=?";
    public static final String DELETE_OAUTH_AUTHORIZATION_CODE =
            "DELETE FROM IDN_OAUTH2_AUTHORIZATION_CODE WHERE CODE_ID=?";
    public static final String GET_OAUTH_ACCESS_TOKEN = "SELECT TOKEN_ID, ACCESS_TOKEN, REFRESH_TOKEN, " +
            "CONSUMER_KEY_ID FROM IDN_OAUTH2_ACCESS_TOKEN ORDER BY TOKEN_ID LIMIT ?, ?";
    public static final String GET_OAUTH_ACCESS_TOKEN_POSTGRE = "SELECT TOKEN_ID, ACCESS_TOKEN, REFRESH_TOKEN, " +
            "CONSUMER_KEY_ID FROM IDN_OAUTH2_ACCESS_TOKEN ORDER BY TOKEN_ID LIMIT ? OFFSET ?";
    public static final String GET_OAUTH_ACCESS_TOKEN_OTHER = "SELECT TOKEN_ID, ACCESS_TOKEN, REFRESH_TOKEN, " +
            "CONSUMER_KEY_ID FROM IDN_OAUTH2_ACCESS_TOKEN ORDER BY TOKEN_ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    public static final String UPDATE_OAUTH_ACCESS_TOKEN =
            "UPDATE IDN_OAUTH2_ACCESS_TOKEN SET ACCESS_TOKEN=?, REFRESH_TOKEN=? WHERE TOKEN_ID=?";
    public static final String GET_TEMP_OAUTH_ACCESS_TOKEN = "SELECT TOKEN_ID, ACCESS_TOKEN, REFRESH_TOKEN, " +
            "CONSUMER_KEY_ID, AUTHZ_USER, TENANT_ID, USER_DOMAIN, USER_TYPE, GRANT_TYPE, TIME_CREATED, " +
            "REFRESH_TOKEN_TIME_CREATED, VALIDITY_PERIOD, REFRESH_TOKEN_VALIDITY_PERIOD, TOKEN_SCOPE_HASH, " +
            "TOKEN_STATE, TOKEN_STATE_ID, SUBJECT_IDENTIFIER, ACCESS_TOKEN_HASH, REFRESH_TOKEN_HASH, IDP_ID, " +
            "TOKEN_BINDING_REF, AVAILABILITY FROM IDN_OAUTH2_ACCESS_TOKEN_TEMP ORDER BY SYNC_ID LIMIT ?, ?";
    public static final String GET_TEMP_OAUTH_ACCESS_TOKEN_POSTGRE = "SELECT TOKEN_ID, ACCESS_TOKEN, REFRESH_TOKEN, " +
            "CONSUMER_KEY_ID, AUTHZ_USER, TENANT_ID, USER_DOMAIN, USER_TYPE, GRANT_TYPE, TIME_CREATED, " +
            "REFRESH_TOKEN_TIME_CREATED, VALIDITY_PERIOD, REFRESH_TOKEN_VALIDITY_PERIOD, TOKEN_SCOPE_HASH, " +
            "TOKEN_STATE, TOKEN_STATE_ID, SUBJECT_IDENTIFIER, ACCESS_TOKEN_HASH, REFRESH_TOKEN_HASH, IDP_ID, " +
            "TOKEN_BINDING_REF, AVAILABILITY FROM IDN_OAUTH2_ACCESS_TOKEN_TEMP ORDER BY SYNC_ID LIMIT ? OFFSET ?";
    public static final String GET_TEMP_OAUTH_ACCESS_TOKEN_OTHER = "SELECT TOKEN_ID, ACCESS_TOKEN, REFRESH_TOKEN, " +
            "CONSUMER_KEY_ID, AUTHZ_USER, TENANT_ID, USER_DOMAIN, USER_TYPE, GRANT_TYPE, TIME_CREATED, " +
            "REFRESH_TOKEN_TIME_CREATED, VALIDITY_PERIOD, REFRESH_TOKEN_VALIDITY_PERIOD, TOKEN_SCOPE_HASH, " +
            "TOKEN_STATE, TOKEN_STATE_ID, SUBJECT_IDENTIFIER, ACCESS_TOKEN_HASH, REFRESH_TOKEN_HASH, IDP_ID, " +
            "TOKEN_BINDING_REF, AVAILABILITY FROM IDN_OAUTH2_ACCESS_TOKEN ORDER BY SYNC_ID OFFSET ? ROWS " +
            "FETCH NEXT ? ROWS ONLY";
    public static final String INSERT_OAUTH_ACCESS_TOKEN =
            "INSERT INTO IDN_OAUTH2_ACCESS_TOKEN (TOKEN_ID, ACCESS_TOKEN, REFRESH_TOKEN, CONSUMER_KEY_ID, " +
                    "AUTHZ_USER, TENANT_ID, USER_DOMAIN, USER_TYPE, GRANT_TYPE, TIME_CREATED, " +
                    "REFRESH_TOKEN_TIME_CREATED, VALIDITY_PERIOD, REFRESH_TOKEN_VALIDITY_PERIOD, TOKEN_SCOPE_HASH, " +
                    "TOKEN_STATE, TOKEN_STATE_ID, SUBJECT_IDENTIFIER, ACCESS_TOKEN_HASH, REFRESH_TOKEN_HASH, IDP_ID, " +
                    "TOKEN_BINDING_REF) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ON " +
                    "DUPLICATE KEY UPDATE ACCESS_TOKEN=?, REFRESH_TOKEN=?, CONSUMER_KEY_ID=?, AUTHZ_USER=?, " +
                    "TENANT_ID=?, USER_DOMAIN=?, USER_TYPE=?, GRANT_TYPE=?, TIME_CREATED=?, " +
                    "REFRESH_TOKEN_TIME_CREATED=?, VALIDITY_PERIOD=?, REFRESH_TOKEN_VALIDITY_PERIOD=?, " +
                    "TOKEN_SCOPE_HASH=?, TOKEN_STATE=?, TOKEN_STATE_ID=?, SUBJECT_IDENTIFIER=?, ACCESS_TOKEN_HASH=?, " +
                    "REFRESH_TOKEN_HASH=?, IDP_ID=?, TOKEN_BINDING_REF=?";
    public static final String DELETE_OAUTH_ACCESS_TOKEN = "DELETE FROM IDN_OAUTH2_ACCESS_TOKEN WHERE TOKEN_ID=?";
    public static final String GET_OAUTH_SECRET = "SELECT ID, CONSUMER_SECRET, APP_NAME " +
            "FROM IDN_OAUTH_CONSUMER_APPS ORDER BY ID LIMIT ?, ?";
    public static final String GET_OAUTH_SECRET_POSTGRE = "SELECT ID, CONSUMER_SECRET, APP_NAME " +
            "FROM IDN_OAUTH_CONSUMER_APPS ORDER BY ID LIMIT ? OFFSET ?";
    public static final String GET_OAUTH_SECRET_OTHER = "SELECT ID, CONSUMER_SECRET, APP_NAME " +
            "FROM IDN_OAUTH_CONSUMER_APPS ORDER BY ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    public static final String UPDATE_OAUTH_SECRET = "UPDATE IDN_OAUTH_CONSUMER_APPS SET CONSUMER_SECRET=? WHERE ID=?";
    public static final String GET_TEMP_OAUTH_SCOPE = "SELECT TOKEN_ID, TOKEN_SCOPE, TENANT_ID, AVAILABILITY FROM " +
            "IDN_OAUTH2_ACCESS_TOKEN_SCOPE_TEMP ORDER BY SYNC_ID LIMIT ?, ?";
    public static final String GET_TEMP_OAUTH_SCOPE_POSTGRE = "SELECT TOKEN_ID, TOKEN_SCOPE, TENANT_ID, AVAILABILITY" +
            " FROM IDN_OAUTH2_ACCESS_TOKEN_SCOPE_TEMP ORDER BY SYNC_ID LIMIT ? OFFSET ?";
    public static final String GET_TEMP_OAUTH_SCOPE_OTHER = "SELECT TOKEN_ID, TOKEN_SCOPE, TENANT_ID, AVAILABILITY" +
            " FROM IDN_OAUTH2_ACCESS_TOKEN_SCOPE_TEMP ORDER BY SYNC_ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    public static final String INSERT_OAUTH_SCOPE = "INSERT INTO IDN_OAUTH2_ACCESS_TOKEN_SCOPE (TOKEN_ID, " +
            "TOKEN_SCOPE, TENANT_ID) VALUES (?, ?, ?) ON DUPLICATE KEY UPDATE TENANT_ID=?";
    public static final String DELETE_OAUTH_SCOPE = "DELETE FROM IDN_OAUTH2_ACCESS_TOKEN_SCOPE WHERE TOKEN_ID=? AND " +
            "TOKEN_SCOPE=?";
    public static final String GET_BPS_PASSWORD = "SELECT PROFILE_NAME, USERNAME, TENANT_ID, PASSWORD " +
            "FROM WF_BPS_PROFILE ORDER BY PROFILE_NAME, TENANT_ID LIMIT ?, ?";
    public static final String GET_BPS_PASSWORD_POSTGRE = "SELECT PROFILE_NAME, USERNAME, TENANT_ID, PASSWORD " +
            "FROM WF_BPS_PROFILE ORDER BY PROFILE_NAME, TENANT_ID LIMIT ? OFFSET ?";
    public static final String GET_BPS_PASSWORD_OTHER = "SELECT PROFILE_NAME, USERNAME, TENANT_ID, PASSWORD " +
            "FROM WF_BPS_PROFILE ORDER BY PROFILE_NAME, TENANT_ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    public static final String UPDATE_BPS_PASSWORD = "UPDATE WF_BPS_PROFILE SET PASSWORD=? WHERE PROFILE_NAME=? AND " +
            "TENANT_ID=?";
    public static final String GET_WF_REQUEST = "SELECT UUID, REQUEST FROM WF_REQUEST ORDER BY UUID LIMIT ?, ?";
    public static final String GET_WF_REQUEST_POSTGRE = "SELECT UUID, REQUEST FROM WF_REQUEST ORDER BY UUID LIMIT ? " +
            "OFFSET ?";
    public static final String GET_WF_REQUEST_OTHER =
            "SELECT UUID, REQUEST FROM WF_REQUEST ORDER BY UUID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    public static final String UPDATE_WF_REQUEST = "UPDATE WF_REQUEST SET REQUEST=? WHERE UUID=?";
    public static final String GET_REG_PROPERTY_DATA = "SELECT REG_ID, REG_NAME, REG_VALUE, REG_TENANT_ID " +
            "FROM REG_PROPERTY WHERE REG_NAME=? ORDER BY REG_ID, REG_TENANT_ID LIMIT ?, ?";
    public static final String GET_REG_PROPERTY_DATA_POSTGRE = "SELECT REG_ID, REG_NAME, REG_VALUE, REG_TENANT_ID " +
            "FROM REG_PROPERTY WHERE REG_NAME=? ORDER BY REG_ID, REG_TENANT_ID LIMIT ? OFFSET ?";
    public static final String GET_REG_PROPERTY_DATA_OTHER = "SELECT REG_ID, REG_NAME, REG_VALUE, REG_TENANT_ID " +
            "FROM REG_PROPERTY WHERE REG_NAME=? ORDER BY REG_ID, REG_TENANT_ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    public static final String UPDATE_REG_PROPERTY_DATA =
            "UPDATE REG_PROPERTY SET REG_VALUE=? WHERE REG_ID=? AND REG_TENANT_ID=?";
}
