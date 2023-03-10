import { useNavigate } from "react-router-dom";

const Login=()=>{
 
    const navigate= useNavigate();
    function success(){
        // fetch('http://localhost:8080/login',{
        //        method:"GET"
        //    })
        //    .then(res => res.json())
        //    .then(data => setUser(data))
        console.log("call");
        navigate(`/`);
      }
    return(
        <div>
  <body>
     <div class="container">
      <form class="form-signin" method="post" action="http://localhost:8080/login">
        <h2 class="form-signin-heading">Please sign in</h2>
        <p>
          <label for="username" class="sr-only">Username</label>
          <input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus/>
        </p>
        <p>
          <label for="password" class="sr-only">Password</label>
          <input type="password" id="password" name="password" class="form-control" placeholder="Password" required/>
        </p>
        <button class="btn btn-lg btn-primary btn-block" type="submit" onClick="success">Sign in</button>
      </form>
</div>
</body>
        </div>

    )
}
export default Login;