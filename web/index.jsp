<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="style.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>  
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script> 
        <script type="text/javascript" src="JS/jquery-1.4.2.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
                $('#login').click(function(e) {
                    e.preventDefault();
                    var $form = $("#signinform");
                    var serializedData = $form.serialize();
                    $.ajax({
                        url: "login",
                        type: "post",
                        data: serializedData,
                        cache: true,
                        success: function(data) {
                           $( "#signinform" ).submit();
                        },
                        error: function (request, status, error) {
                           $("#emaillogin").val('');
                           $("#passlogin").val('');
                           $("#message").html("<p>Email or password is incorrext</p>").slideDown('slow');
                        }
                    });
                });
                
                $('#signup').click(function(e) {
                    e.preventDefault();
                    var $form = $("#signupform");
                    var serializedData = $form.serialize();
                    $.ajax({
                        url: "signup",
                        type: "post",
                        data: serializedData,
                        cache: true,
                        success: function(data) {
                           $("#nusername").val('');
                           $("#nemail").val('');
                           $("#npassword").val('');
                           alert('Tài khoản của bạn đã được đăng ký! \nMời bạn đăng nhập');
                        },
                        error: function (request, status, error) {
                           $("#nusername").val('');
                           $("#nemail").val('');
                           $("#npassword").val('');
                           $("#message1").html("<p>Email was existed! Try again!</p>").slideDown('slow');
                        }
                    });
                });
        });      
        </script>
    </head>
    
    <body>
        <%
            String err=request.getParameter("err");
            if ("2".equals(err)) {
                    out.println("<script type=\"text/javascript\">");  
                    out.println(" $(\"myModal\").modal();");
                    out.println("</script>");
            }
        %>
        
<!--        SIGN UP FORM         -->
        <h1 style="padding-bottom: 20px">Cake Shop</h1>
        <div class="container" id="container">
            <div class="form-container sign-up-container">
                <form action="signup" method="POST" id="signupform">
                    <h1>Create Account</h1>
                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    </div>
                    <span>or use your email for registration</span>
                    <input type="text" placeholder="Name" name="nusername" id="nusername"/>
                    <input type="email" placeholder="Email" name="nemail" id="nemail"/>
                    <input type="password" placeholder="Password" name="npassword" id="npassword"/>
                    <div id="message1"></div>
                    <button type="submit" id ="signup">Sign Up</button>
                </form>
            </div>
                            
<!--        LOGIN FORM         -->
            <div class="form-container sign-in-container">
                <form action="login" method="POST" id="signinform">
                    <h1>Sign in</h1>
                    <div class="social-container">
                        <a href="#" class="social"><i class="fab fa-facebook-f"></i></a>
                        <a href="#" class="social"><i class="fab fa-google-plus-g"></i></a>
                    </div>
                    <span>or use your account</span>
                    <input type="email" placeholder="Email" name="email" id="emaillogin"/>
                    <input type="password" placeholder="Password" name="password" id="passlogin" />
                    <a href="#">Forgot password?</a>
                    <div id="message"></div>
                    <button type="submit" id ="login">Sign In</button>
                </form>
            </div>
<!--       OVERLAY        -->
            <div class="overlay-container">
                <div class="overlay">
                    <div class="overlay-panel overlay-left">
                            <h1>Welcome Back!</h1>
                            <p>To keep connected with us please login with your personal info</p>
                            <button class="ghost" id="signIn">Sign In</button>
                    </div>
                    <div class="overlay-panel overlay-right">
                            <h1>Hello, Friend!</h1>
                            <p>Enter your personal details and start journey with us</p>
                            <button class="ghost" id="signUp">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>

    </body>
    <script type="text/javascript" src="script.js"></script>
</html>
