import { useState } from 'react'

export const Login: React.FC = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')

  const handleSubmit = (e: React.FormEvent<HTMLFormElement>): void => {
    e.preventDefault()
    console.log(email)
    console.log(password)
    const fields = Object.fromEntries(new FormData(e.currentTarget))
    console.log(fields)
  }

  const handleChangeEmail = (e: React.ChangeEvent<HTMLInputElement>): void => {
    const data = e.target.value
    setEmail(data)
  }

  const handleChangePassword = (e: React.ChangeEvent<HTMLInputElement>): void => {
    const data = e.target.value
    setPassword(data)
  }

  return (
    <>
      <h3>Login</h3>
      <form className='form' onSubmit={handleSubmit}>
        <label>Email:</label>
        <input placeholder="email" onChange={handleChangeEmail}/>
        <label>Password:</label>
        <input placeholder="password" type='password' onChange={handleChangePassword}/>
        <button type='submit'>sing up</button>
      </form>
    </>
  )
}
