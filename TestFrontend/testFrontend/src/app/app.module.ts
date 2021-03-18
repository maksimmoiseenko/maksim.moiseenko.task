import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { LoginComponent } from './Components/login/login.component';
import {RouterModule} from '@angular/router';
import {AppRoutingModule} from './app-routing.module';
import {HTTP_INTERCEPTORS, HttpClient, HttpClientModule} from '@angular/common/http';
import { SensorsComponent } from './Components/sensors/sensors.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatPaginatorModule, PageEvent} from '@angular/material/paginator';
import {JwPaginationModule} from "jw-angular-pagination";
import { FormComponent } from './Components/form/form.component';
import {MatSelectModule} from "@angular/material/select";
import {TokenInterceptor} from './TokenInterceptor';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SensorsComponent,
    FormComponent

  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    JwPaginationModule,
    MatSelectModule

  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
