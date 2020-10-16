import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from './Components/login/login.component';
import {NgModule} from '@angular/core';
import {SensorsComponent} from './Components/sensors/sensors.component';
import {FormComponent} from './Components/form/form.component';



const routes: Routes = [
  {path: '', pathMatch: 'full', redirectTo: 'login'},
  {path: 'login', component: LoginComponent},
  {path: 'sensors', component: SensorsComponent},
  {path: 'form', component: FormComponent}


];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
