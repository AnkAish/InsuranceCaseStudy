import { Component, Input, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { LoginService } from 'src/app/services/home/login.service'; 
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  hide=true

  constructor(private loginService:LoginService,private snack:MatSnackBar) { }

  credentials={
    userName:'',
    password:''
  }
  user:any
  @Input() imgPath:string = "./assets/images/login.jpg";
  onSubmit(){
    if(this.credentials.userName.trim()=='' || this.credentials.userName==null){
        this.snack.open('UserName is required !!','',{duration: 3000,});
        return
    }
    if(this.credentials.password.trim()=='' || this.credentials.password==null){
     this.snack.open('Password is required !!','',{duration: 3000,});
      return
    }
    else{
      //Token Generate
      this.loginService.generateToken(this.credentials).subscribe(
        (response:any)=>{
          console.log(response.token);
          this.loginService.loginUser(response.token)
          this.loginService.getCurrentUser().subscribe(
            (user:any)=>{
            this.loginService.setUser(user);
            console.log(user);
            
            //Redirect ...ADMIN: adminDashBoard
            if(this.loginService.getUserRole()=="ADMIN")
              window.location.href="/admin"
            //Redirect ...NORMAL: userDashBoard
            else if(this.loginService.getUserRole()=="NORMAL")
              window.location.href="/dashBoard"
            //Redirect ...WRITER: UnserWriterDashboard
            else if(this.loginService.getUserRole()=="WRITER")
              window.location.href="/underDashboard"
            else{
              this.loginService.logOut()
            }
            (error:any)=>{
              Swal.fire("Error !!","SERVER ERROR","error");
            }
            }
          )
        },
        error=>{
          Swal.fire("Error !!","UserName or Password Is Incorrect","error");
        }
      )
    }
    
  }
 

  ngOnInit(): void {
  }
}
