import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  items: Array<any> = [];
  viewCatalog: boolean;
  values = '';
  constructor() {
    this.items = [
      {name:  '../../../assets/images/img_mountains_wide.jpg'}
    ];
  }

  ngOnInit() {
  }

  typeSearch(event: any) {
    if (event.target.value.length > 0) {
      this.viewCatalog = true;
    } else {
      this.viewCatalog = false;
    }
  }
}
