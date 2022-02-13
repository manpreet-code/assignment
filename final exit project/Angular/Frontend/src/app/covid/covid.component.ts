import { Component, OnInit } from '@angular/core';
import * as Chart from 'chart.js'
import { CovidService } from '../services/covid.service';
@Component({
  selector: 'app-covid',
  templateUrl: './covid.component.html',
  styleUrls: ['./covid.component.css']
})
export class CovidComponent implements OnInit {

  count: any;
  country: any;
  countryHTML: string;
  confirm: number;
  deaths: number;
  active: number;

  canvas: any;
  ctx: any;
  constructor(private covids:CovidService) { }

  ngOnInit(): void {
    this.covids.getcountries().subscribe(data => {
      this.count = data;
      this.count.sort((a, b) => (a.Country > b.Country) ? 1 : -1);
    })
    this.country = 'india';
    this.countryHTML = "india";
    this.getcoronadata();
  }

  createChart(activeCases, deathCases, confirmCases) {
    console.log("Chart");
    // console.log(activeCases.length);
    // console.log(activeCases);
    // console.log(deathCases+"/");
    // console.log(confirmCases+"/");
    var chart = document.getElementById("chart");
    chart.innerHTML = "";
    chart.innerHTML = '<canvas id="myChart" width = "500" height = "400" > </canvas>';
    this.ctx = document.getElementById("myChart");
    this.ctx.height = 400;
    this.ctx.width = 700;
    let myChart = new Chart(this.ctx, {
      type: 'line',
      data: {
        labels: ["Day1", "Day2", "Day3", "Day4", "Day5", "Day6", "Day7", "Day8", "Day9", "Day10", "Day11", "Day12", "Day13", "Day14", "Day15", "Day16", "Day17", "Day18", "Day19", "Day20", "Day21", "Day22", "Day23", "Day24", "Day25", "Day26", "Day27", "Day28", "Day29", "Day30"],
        datasets: [{
          data: activeCases,
          label: "Active Cases",
          borderColor: "#3e95cd",
          fill: false
        }, {
          data: deathCases,
          label: "Deaths",
          borderColor: "red",
          fill: false
        }, {
          data: confirmCases,
          label: "Confirm Cases",
          borderColor: "#3cba9f",
          fill: false
        }
        ]
      },
      options: {
        responsive: false,
        display: true,
        scales: {
          yAxes: [{
            ticks: {
              beginAtZero: true
            }
          }]
        }
      }
    });
  }

  getcountry(country: any) {

    this.country = country;
  }
  getcoronadata() {
    let activeCases = [];
    let confirmCases = [];
    let deathCases = [];

    this.confirm = null;
    this.active = null;
    this.deaths = null;

    let to = new Date();
    to.setDate(to.getDate() - 1);
    let from = new Date();
    from.setMonth(from.getMonth() - 1);
    from.setDate(from.getDate() - 1);

    this.covids.getcoronarealdata(this.country, this.formatDate(from), this.formatDate(to)).subscribe(
      async (data) => {

        if (data) {
          
          let j = 30;
          for (let i = data.length-1; i>0 && j>0  ; i--) {
            activeCases.unshift(data[i].Active);
            confirmCases.unshift(data[i].Confirmed);
            deathCases.unshift(data[i].Deaths);
            j--;
          }
          this.createChart(activeCases, deathCases, confirmCases);
          console.log(activeCases);
        }
        var ob = data[data.length - 1];
        this.confirm = ob.Confirmed;
        this.active = ob.Active;
        this.deaths = ob.Deaths;
      },
      (error) => {
        alert('Cannot get data!');
      });
    this.countryHTML = this.country;
  }
  formatDate(date) {
    var d = new Date(date),
      month = '' + (d.getMonth() + 1),
      day = '' + d.getDate(),
      year = d.getFullYear();

    if (month.length < 2)
      month = '0' + month;
    if (day.length < 2)
      day = '0' + day;
    return [year, month, day].join('-');
  }

}