import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { Food } from '../model/food/food';
import { FoodServiceService } from '../service/food/food-service.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  rfFood: FormGroup;
  food: Food[];
  name: string = "";

  constructor(
    private _foodService: FoodServiceService,
  ) {
  }

  ngOnInit(): void {
  }

  searchAll() {
    this._foodService.findAllFood(this.name).subscribe(
      (data) => {
        this.food = data;
      }
    );
  }

}
