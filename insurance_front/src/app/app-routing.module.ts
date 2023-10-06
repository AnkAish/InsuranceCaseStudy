import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutusclickComponent } from './components/home/aboutUs/aboutusclick.component';
import { AdminDashBoardComponent } from './components/admin/admin-dash-board/admin-dash-board.component';
import { ContactusclickComponent } from './components/home/contactUs/contactusclick.component';
import { CustomersignupComponent } from './components/home/signUp/customersignup.component';
import { HomepageComponent } from './components/home/homePage/homepage.component';
import { NomineeComponent } from './components/user/nominee/nominee.component';
import { AdminGuard } from './services/guard/admin.guard'; 
import { UserDashBoardComponent } from './components/user/user-dash-board/user-dash-board.component';
import { UserGuard } from './services/guard/user.guard'; 
import { LoginComponent } from './components/home/login/login.component';
import { PolicyComponent } from './components/admin/policy/policy.component';
import { PlanComponent } from './components/admin/plan/plan.component';
import { ProfileComponent } from './components/user/profile/profile.component'; 
import { AddPolicyComponent } from './components/admin/add-policy/add-policy.component';
import { AddPlanComponent } from './components/admin/add-plan/add-plan.component';
import { BuyPlanComponent } from './components/user/buy-plan/buy-plan.component';
import { RegisteredPlanComponent } from './components/user/registered-plan/registered-plan.component';
import { SingleBuyPlanComponent } from './components/user/single-buy-plan/single-buy-plan.component';
import { CategoryComponent } from './components/user/category/category.component';
import { UnderDashboardComponent } from './components/under-writer/under-dashboard/under-dashboard.component';
import { AllUsersComponent } from './components/admin/all-users/all-users.component';
import { UnderWriterGuard } from './services/guard/under-writer.guard';
import { ARPlansComponent } from './components/under-writer/a-r-plans/a-r-plans.component';
import { UserDetailComponent } from './components/under-writer/user-detail/user-detail.component';
import { HomePolicyComponent } from './components/home/home-policy/home-policy.component';
import { ClaimComponent } from './components/user/claim/claim.component';
import { WelcomeComponent } from './components/welcome/welcome.component';
import { RegisteredClaimComponent } from './components/user/registered-claim/registered-claim.component';
import { ClaimRequestsComponent } from './components/under-writer/claim-requests/claim-requests.component';
import { ClaimDetailComponent } from './components/under-writer/claim-detail/claim-detail.component';
import { AdminUserPlanComponent } from './components/admin/admin-user-plan/admin-user-plan.component';
import { NomineeDetailComponent } from './components/user/nominee-detail/nominee-detail.component';
import { UpdatePasswordComponent } from './components/user/update-password/update-password.component';
const routes: Routes = [
{path: 'homePage', component:HomepageComponent,pathMatch:"full"},
{path: '',component:HomepageComponent,pathMatch:"full"},
{path: 'aboutUs', component: AboutusclickComponent,pathMatch:"full"},
{path: 'contactUs', component:ContactusclickComponent,pathMatch:"full"},
{path: 'login', component:LoginComponent,pathMatch:"full"},
{path: 'signUp', component: CustomersignupComponent,pathMatch:"full"},
{path:'homePolicy/:policyId', component:HomePolicyComponent,pathMatch:"full"},
{path: 'admin', component: AdminDashBoardComponent,canActivate:[AdminGuard],
  children:[
    {
      path: '',component:WelcomeComponent
    },
    {
      path:'policy',component:PolicyComponent
    },
    {
      path:'addPolicy',component:AddPolicyComponent
    },
    {
      path:'plan',component:PlanComponent
    },
    {
      path:'addPlan',component:AddPlanComponent
    },
    {
      path:'allUsers',component:AllUsersComponent
    },
    {
      path:'userPlans/:id',component:AdminUserPlanComponent
    }
  ]
},
{path: 'dashBoard', component: UserDashBoardComponent,canActivate:[UserGuard],
  children:[
    {
      path: '',component:WelcomeComponent
    },
    {
      path:'profile',component:ProfileComponent
    },
    {
      path:'resetPassword',component:UpdatePasswordComponent
    },
    {
      path:'category',component:CategoryComponent,
    },
    {
      path:'buyPlan/:policyId',component:BuyPlanComponent
    },
    {
      path:'singlePlan/:planId',component:SingleBuyPlanComponent
    },
    {
      path:'nominee',component:NomineeComponent
    },
    {
      path:'nomineeDetail/:orderId',component:NomineeDetailComponent
    },
    {
      path:'registeredPlan',component:RegisteredPlanComponent
    },
    {
      path:'claim/:orderId',component:ClaimComponent
    },
    {
      path:'registeredClaim',component:RegisteredClaimComponent
    },
  ]
},
{path:'underDashboard',component:UnderDashboardComponent,canActivate:[UnderWriterGuard],
children:[
  {
    path:'',component:WelcomeComponent
  },
  {
    path:'approveReject',component:ARPlansComponent
  },
  {
    path:'userDetail/:orderId',component:UserDetailComponent
  },
  {
    path:'claimReq',component:ClaimRequestsComponent
  },
  {
    path:'claimDetail/:claimId',component:ClaimDetailComponent
  },
  
]},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
