import '../styles/login.css'

export const Login: React.FC = () => {
  return (
    <div className='container'>
      <div className='box'>
        <div className='box-login' id='login'>
          <div className='header'>
            <h2>Hello, Again!</h2>
            <small>We are happy to have you back!</small>
          </div>
          <form className='form'>
            <div className="input-field">
              <label htmlFor="email">Email:</label>
              <input className='input-box' id="email" type="email" name="email" />
            </div>
            <div className="input-field">
              <label htmlFor="pass">Password:</label>
              <input className='input-box' id="pass" type="password" name="password" />
              <i className='bx bxs-low-vision'></i>
            </div>
            <div className="remember">
              <input className='check' type="checkbox" name="remember" id="rem" />
              <label htmlFor="rem">Remember me</label>
            </div>
            <button className='login-btn' type="submit">Sign in</button>
            <div className='forgot'>
              <a href="#">Forgot Password?</a>
            </div>
          </form>
        </div>
      </div>
    </div>
  )
}
