<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>
    <meta charset="UTF-8">
    <title>Index</title>

</head>
<body>
    Index PAGE
     <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3/jquery.min.js" type="text/javascript"></script>
        <script src='https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit' async defer></script>
     

      <form action="/check"  method="post">
    <p class="captchaMessage">Please verify your gift card with the below security process.</p>
     <div id="captchaContainer"></div>
    <div class="g-recaptcha" data-sitekey="6LcJeRgUAAAAAEVDZ36WP8CHe5gskz9zarRdAnFd" data-captcha=""></div>
    <br>
    <input type=submit value="check"/>
    </form>
        <script type="text/javascript">
        console.log('hello');
        var onloadCallback = function() {
            grecaptcha.render('captchaContainer', {
              'sitekey' : jQuery('.g-recaptcha').attr('data-sitekey'),
              'callback' : verifyCallback,
                   'expired-callback': expCallback
            });
          };
          
          var verifyCallback = function(response) {
              jQuery('.g-recaptcha').attr('data-captcha',response);
              if (jQuery('#captcha').length != 0){
                jQuery('#captcha').val(response);
                jQuery('#userName').val(response);
                
              }
          };
          
          var expCallback = function(response){
              jQuery('.g-recaptcha').attr('data-captcha','');
              if (jQuery('#captcha').length != 0){
                jQuery('#captcha').val('');
                
              }
          };
        </script>
</body>
</html>