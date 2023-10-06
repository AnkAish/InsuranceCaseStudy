import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin/admin.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  policy_data : any[] | undefined;
  policy_id : number | undefined;
  constructor(private policy : AdminService) { }

  ngOnInit(): void {
    this.policy.getPolicies().subscribe((result)=>{
      this.policy_data = result
     },
     error=>{
      console.log(error);
     });
  }
}
