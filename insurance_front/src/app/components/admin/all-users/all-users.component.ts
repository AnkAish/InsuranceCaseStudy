import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin/admin.service';

@Component({
  selector: 'app-all-users',
  templateUrl: './all-users.component.html',
  styleUrls: ['./all-users.component.css']
})
export class AllUsersComponent implements OnInit {
  user : any[] | undefined;
  constructor(private _user : AdminService) { }

  ngOnInit(): void {
    this._user.getUsers().subscribe((result)=>{
      this.user = result
     });
  }


}
