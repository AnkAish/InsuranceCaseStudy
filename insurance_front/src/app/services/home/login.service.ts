import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  url="http://localhost:9119";
  constructor(private http:HttpClient){}

  //Current User: whih is Logged IN
  public getCurrentUser(){
    return this.http.get(`${this.url}/currentUser`);
  }
  //Calling the server to generate token
  public generateToken(credentials:any){
    return this.http.post(`${this.url}/token`,credentials);
  }
  //For Login user
  public loginUser(token:any){
    localStorage.setItem("token",token)
    return true;
  }
  //To check user is logged in or not
  public isLoggedIn(){
    let token=localStorage.getItem("token");
    if(token==undefined || token=='' || token==null)
      return false;
    else
      return true;
  }
  //To Logout
  public logOut(){
    localStorage.removeItem('token');
    localStorage.removeItem('user');
    return true;
  }
  //Get Token
  public getToken(){
   return localStorage.getItem('token');
  }

  //Set UserDetails
  public setUser(user:any){
    localStorage.setItem('user',JSON.stringify(user));
  }
  //Get UserDetails
  public getUser(){
    let userStr= localStorage.getItem('user');
    if(userStr!=null )
      return JSON.parse(userStr)
    else{
      this.logOut();
      return null;
    }
  }

  //Get UserRole
  public getUserRole(){
    let user=this.getUser();
    return user.authorities[0].authority;
  }
}
