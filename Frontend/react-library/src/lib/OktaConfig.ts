export const oktaConfig ={
   clientId:`0oab7ltwlzk0BO1SU697`,
   issuer:`https://trial-5936132.okta.com/oauth2/default`,
   redirectUri:'http://localhost:3000/login/callback',
    scopes: ['openid','profile','email'],
    pkce: true,
    disableHttpsCheck: true,
}