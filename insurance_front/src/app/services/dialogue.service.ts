import { Injectable } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatConfirmDialogueComponent } from '../components/mat-confirm-dialogue/mat-confirm-dialogue.component';

@Injectable({
  providedIn: 'root'
})
export class DialogueService {

  constructor(private dialogue:MatDialog) { }

  openConfirmDialogue(msg:string){
    return this.dialogue.open(MatConfirmDialogueComponent,{
      width:'390px',
      panelClass: 'confirm-dialog-continer',
      position:{top:"10px"},
      data:{
        message :msg
      },
      disableClose:true
    })
  }
}
