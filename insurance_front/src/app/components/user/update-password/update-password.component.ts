import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { DialogueService } from 'src/app/services/dialogue.service';
import { LoginService } from 'src/app/services/home/login.service';
import { UserServiceService } from 'src/app/services/user/user-service.service';

@Component({
  selector: 'app-update-password',
  templateUrl: './update-password.component.html',
  styleUrls: ['./update-password.component.css']
})
export class UpdatePasswordComponent implements OnInit {

  hide = true
  constructor(private userService: UserServiceService,
    private login: LoginService,
    private snack: MatSnackBar,
    private dialogue:DialogueService) { }

  password = ""
  customerSignupForm = new FormGroup({
    'password': new FormControl(null, [Validators.required, Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}')]),
  })

  ngOnInit(): void {
  }

  dataSubmit() {
    this.dialogue.openConfirmDialogue("Are You Sure You Want To Change Password.")
      .afterClosed().subscribe(res => {
        if (res) {
          this.userService.updatePassword(this.password, this.login.getUser().id).subscribe(res => {
            this.snack.open('Password Updated', '', { duration: 3000, });
            window.location.href = '/dashBoard/profile'
          })
        }
      })
  }
}
