import { Component, OnInit } from '@angular/core';

import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Account} from '../../models/Account';
import {LoginService} from '../../services/login.service';
import {Router} from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  account;
  constructor(private router: Router,
              private accountService: LoginService) {
  }
  ngOnInit(): void {
    this.form = new FormGroup({
      login: new FormControl(null, [ Validators.required]),
      password: new FormControl(null, [Validators.required])
    });
  }
  onSubmit(){
    if (this.form.valid){
      this.account = {
        login: this.form.controls.login.value,
        password: this.form.controls.password.value
      };
      const resp = this.accountService.send(this.account).subscribe(response => {
        console.log(response.token);
        console.log(typeof response);
        if (response.role === 'admin' || response.role === 'user') {
          localStorage.setItem('role', response.role);
          localStorage.setItem('token', response.token);
          console.log(response.token);
          this.router.navigate(['/sensors']);
        }
        if (response === 'incorrect'){
          alert('Incorrect login or password');
        }
      });
    }
   }
}
