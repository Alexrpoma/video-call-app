import { useState } from 'react'
import '../styles/login.css'

export const Login: React.FC = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const emailHandleChange = (e: React.ChangeEvent<HTMLInputElement>): void => {
    const email = e.target.value
    setEmail(email)
  }

  const passwordHandleChange = (e: React.ChangeEvent<HTMLInputElement>): void => {
    const pass = e.target.value
    setPassword(pass)
  }

  const onSubmit = (e: React.FormEvent<HTMLElement>): void => {
    e.preventDefault()
    console.log('Email: ', email)
    console.log('Password', password)
    setEmail('')
    setPassword('')
  }

  return (
    <div className='container'>
      <div className='box'>
        <div className='box-login' id='login'>
          <div className='header'>
            <h2>Hello, Again!</h2>
            <small>We are happy to have you back!</small>
          </div>
          <form className='form' onSubmit={onSubmit}>
            <div className="input-field">
              <label htmlFor="email">Email:</label>
              <input
                className='input-box'
                id="email"
                type="email"
                name="email"
                onChange={emailHandleChange}
                value={email} />
            </div>
            <div className="input-field">
              <label htmlFor="pass">Password:</label>
              <input
                className='input-box'
                id="pass"
                type="password"
                name="password"
                onChange={passwordHandleChange}
                value={password} />
              <i className='bx bxs-low-vision'></i>
            </div>
            <div className="remember">
              <input
                className='check'
                id="rem"
                type="checkbox"
                name="remember" />
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
