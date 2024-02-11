export const oktaConfig ={
   clientId:`0oaexijqmnjQ5Sz4a5d7`,
   issuer:`https://dev-85275676.okta.com/oauth2/default`,
   redirectUri:'https://localhost:3000/login/callback',
    scopes: ['openid','profile','email'],
    pkce: true,
    disableHttpsCheck: true,
}