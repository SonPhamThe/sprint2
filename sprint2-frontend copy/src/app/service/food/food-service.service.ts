import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Category } from 'src/app/model/food/category';
import { Food } from 'src/app/model/food/food';
import { ImgFood } from 'src/app/model/food/img_food';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FoodServiceService {

  constructor(private _httpClient: HttpClient) { }

  findAllFood(name: string): Observable<Food[]> {
    return this._httpClient.get<Food[]>(environment.api_url_list_food + `?name=` + name);
  }

  findImageFood(id: number): Observable<ImgFood[]> {
    return this._httpClient.get<ImgFood[]>(environment.api_url_find_image_food_by_id + id);
  }

  findAllCategory(): Observable<Category[]> {
    return this._httpClient.get<Category[]>(environment.api_url_list_category);
  }
}
