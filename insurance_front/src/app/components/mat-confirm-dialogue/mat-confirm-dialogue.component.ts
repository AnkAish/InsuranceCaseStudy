import { Component, OnInit, Inject } from '@angular/core';
import { MAT_DIALOG_DATA , MatDialogRef} from '@angular/material/dialog';

@Component({
  selector: 'app-mat-confirm-dialogue',
  templateUrl: './mat-confirm-dialogue.component.html',
  styleUrls: ['./mat-confirm-dialogue.component.css']
})
export class MatConfirmDialogueComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data:any,
  public dialogRef:MatDialogRef<MatConfirmDialogueComponent>) { }

  ngOnInit(): void {
  }

  closeDialogue(){
    this.dialogRef.close(false);
  }

}
