import { Component, OnInit} from '@angular/core';
import {SensorService} from '../../services/sensor.service';
import {Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Sensor} from "../../models/Sensor";

@Component({
  selector: 'app-sensors',
  templateUrl: './sensors.component.html',
  styleUrls: ['./sensors.component.css']
})
export class SensorsComponent implements OnInit {
  items: any;
  pageOfItems: Array<any>;
  isAdmin: boolean;
  form: FormGroup;
  isValid=false;
  ngOnInit() {
      if (localStorage.getItem('role') === 'admin'){
        this.isAdmin = true;
      }
      else { this.isAdmin = false; }
      const resp = this.sensorService.getSensors();
      resp.subscribe((data) => {
       console.log(data);
       this.items = data;
      });

      this.form = new FormGroup({
        search: new FormControl()
      });
  }
  constructor(private sensorService: SensorService,
              private router: Router) {
  }
  logOut(){
    localStorage.clear();
    this.router.navigate(['/login']);
  }
  onSubmit(){
    if (this.form.controls.search.value !== ''){
      this.sensorService.search(this.form.controls.search.value).subscribe((data) => {
        this.items = data;
      });
    }
    else {
      this.sensorService.getSensors().subscribe((data) => {
        this.items = data;
      });
    }
  }

  onDelete(id: number) {
    this.sensorService.delete(id);
    location.reload();
  }
  onEdit(sensorId: number) {
    localStorage.setItem('Id', sensorId.toString());
    this.router.navigate(['/form']);

  }
  onChangePage(pageOfItems: Array<any>) {

    this.pageOfItems = pageOfItems;
  }

  addSensor() {
    localStorage.setItem('Id', '0');
    this.router.navigate(['/form']);
  }
}
