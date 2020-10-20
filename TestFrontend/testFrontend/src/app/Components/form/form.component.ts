import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {SensorService} from '../../services/sensor.service';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Type} from '../../models/Type';
import {Unit} from '../../models/Unit';
import {SensorDto} from "../../models/SensorDto";
import {Sensor} from "../../models/Sensor";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})

export class FormComponent implements OnInit {
  form: FormGroup;
  types: any;
  units: any;
  id: number;
  sensor: Sensor;
  isValid = false;
  sensor1: any;
  n: number;
  constructor(private router: Router,
              private sensorService: SensorService) { }

  ngOnInit(): void {

    this.form = new FormGroup({
      name: new FormControl(null, [ Validators.required]),
      model: new FormControl(null, [Validators.required]),
      location: new FormControl(),
      description: new FormControl(),
      type: new FormControl(null, [ Validators.required]),
      unit: new FormControl(null, [Validators.required]),
      rangeFrom: new FormControl(null, [ Validators.required]),
      rangeTo: new FormControl(null, [Validators.required])
    });
    this.sensorService.getUnits().subscribe((data) => {
      this.units = data;
    });
    this.sensorService.getTypes().subscribe((data) => {
      this.types = data;
    });
    if (localStorage.getItem('Id') !== '0'){
      this.n = +localStorage.getItem('Id');
      console.log(this.n);
      this.sensorService.getById(this.n).subscribe((data) => {
        this.sensor1 = data;
        this.initForm();
          });
    }
  }
  initForm(){
    this.form.setValue({
      name: this.sensor1.name,
      model: this.sensor1.model,
      location: this.sensor1.location,
      description: this.sensor1.description,
      type: this.sensor1.type,
      unit: this.sensor1.unit,
      rangeFrom: this.sensor1.rangeFrom,
      rangeTo: this.sensor1.rangeTo
    });
  }
  validate() {
    this.isValid = this.form.get('rangeTo').value > this.form.get('rangeFrom').value;
  }
  back(){
      this.router.navigate(['/sensors']);
  }
  onSubmit(){
    if (this.form.valid){
      this.id = +localStorage.getItem('Id');
      this.sensor = {
        id: this.id,
        name: this.form.controls.name.value,
        model: this.form.controls.model.value,
        description: this.form.controls.description.value,
        location: this.form.controls.location.value,
        type: this.form.controls.type.value,
        unit: this.form.controls.unit.value,
        rangeTo: this.form.controls.rangeTo.value,
        rangeFrom: this.form.controls.rangeFrom.value
      };
      this.sensorService.save(this.sensor);
      console.log(this.id);
      console.log(this.form.value);

    }
  }


}
