import { LOGIN_API_URL } from '../constants/apiConnection'
import type { UserLoginData, User } from '../interfaces/user'

export const login = async (signIn: UserLoginData): Promise<User> => {
  try {
    const user = await fetch(LOGIN_API_URL, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(signIn)
    })
    return await user.json()
  } catch (error) {
    throw new Error('Fetching error!')
  }
}
