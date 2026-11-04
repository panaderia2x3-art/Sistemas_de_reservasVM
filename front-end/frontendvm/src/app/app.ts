import { Component, signal } from '@angular/core';
import { Nav } from './Components/nav/nav';
import { Footer } from './Components/footer/footer';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [Nav, Footer, RouterOutlet],
  styleUrl: './app.scss',
  templateUrl: './app.html',
})
export class App {
  protected readonly title = signal('frontendvm');
}
