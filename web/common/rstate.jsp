<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <body>
        <script>
            localStorage.setItem("redirect", "state");
            document.location.href = './app';
        </script>
    </body>
</html>