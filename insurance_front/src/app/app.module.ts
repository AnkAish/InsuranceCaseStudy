import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatButtonModule} from '@angular/material/button';
import { RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/home/navbar/navbar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import {MatCardModule} from '@angular/material/card';
import {MatSelectModule} from '@angular/material/select';
import { HomepageComponent } from './components/home/homePage/homepage.component';
import { AboutusclickComponent } from './components/home/aboutUs/aboutusclick.component';
import { ContactusclickComponent } from './components/home/contactUs/contactusclick.component';
import { LoginComponent } from './components/home/login/login.component';
import { CustomersignupComponent } from './components/home/signUp/customersignup.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule } from '@angular/material/core';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatDividerModule} from '@angular/material/divider';
import { HttpClientModule } from '@angular/common/http';
import { NomineeComponent } from './components/user/nominee/nominee.component';
import { PlanComponent } from './components/admin/plan/plan.component';
import { AdminDashBoardComponent } from './components/admin/admin-dash-board/admin-dash-board.component';
import { UserDashBoardComponent } from './components/user/user-dash-board/user-dash-board.component';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import { PolicyComponent } from './components/admin/policy/policy.component';
import {MatListModule} from '@angular/material/list';
import { ProfileComponent } from './components/user/profile/profile.component';
import { AddPolicyComponent } from './components/admin/add-policy/add-policy.component';
import { AddPlanComponent } from './components/admin/add-plan/add-plan.component';
import { BuyPlanComponent } from './components/user/buy-plan/buy-plan.component';
import { RegisteredPlanComponent } from './components/user/registered-plan/registered-plan.component';
import { SingleBuyPlanComponent } from './components/user/single-buy-plan/single-buy-plan.component';
import { CategoryComponent } from './components/user/category/category.component';
import { UnderDashboardComponent } from './components/under-writer/under-dashboard/under-dashboard.component';
import { SinglePlanComponent } from './components/admin/single-plan/single-plan.component';
import { AllUsersComponent } from './components/admin/all-users/all-users.component';
import { ARPlansComponent } from './components/under-writer/a-r-plans/a-r-plans.component';
import { LoginService } from './services/home/login.service';
import { SignUpService } from './services/home/sign-up.service';
import { authInterceptorProviders } from './services/guard/auth.interceptor';
import { UserDetailComponent } from './components/under-writer/user-detail/user-detail.component';
import {MatDialogModule} from '@angular/material/dialog';
import { MatConfirmDialogueComponent } from './components/mat-confirm-dialogue/mat-confirm-dialogue.component';
import { HomePolicyComponent } from './components/home/home-policy/home-policy.component';
import { ClaimComponent } from './components/user/claim/claim.component';
import { RegisteredClaimComponent } from './components/user/registered-claim/registered-claim.component';
import { ClaimRequestsComponent } from './components/under-writer/claim-requests/claim-requests.component';
import { ClaimDetailComponent } from './components/under-writer/claim-detail/claim-detail.component';
import { AdminUserPlanComponent } from './components/admin/admin-user-plan/admin-user-plan.component';
import { NomineeDetailComponent } from './components/user/nominee-detail/nominee-detail.component';
import { UpdatePasswordComponent } from './components/user/update-password/update-password.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomepageComponent,
    AboutusclickComponent,
    ContactusclickComponent,
    CustomersignupComponent,
    AdminDashBoardComponent,
    NomineeComponent,
    LoginComponent,
    UserDashBoardComponent,
    PlanComponent,
    LoginComponent,
    PolicyComponent,
    ProfileComponent,
    AddPolicyComponent,
    AddPlanComponent,
    BuyPlanComponent,
    RegisteredPlanComponent,
    SingleBuyPlanComponent,
    CategoryComponent,
    UnderDashboardComponent,
    SinglePlanComponent,
    AllUsersComponent,
    ARPlansComponent,
    UserDetailComponent,
    MatConfirmDialogueComponent,
    HomePolicyComponent,
    ClaimComponent,
    RegisteredClaimComponent,
    ClaimRequestsComponent,
    ClaimDetailComponent,
    AdminUserPlanComponent,
    NomineeDetailComponent,
    UpdatePasswordComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatButtonModule,
    FlexLayoutModule,
    MatFormFieldModule,
    MatInputModule,
    MatCardModule,
    FormsModule,
    RouterModule,
    ReactiveFormsModule,
    MatSelectModule,
    MatIconModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSidenavModule,
    MatDividerModule,
    HttpClientModule,
    MatSnackBarModule,
    MatListModule,
    MatDialogModule
  ],

  
  providers: [LoginService, SignUpService,authInterceptorProviders],
  bootstrap: [AppComponent],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ],
  entryComponents:[MatConfirmDialogueComponent]
})
export class AppModule { }
