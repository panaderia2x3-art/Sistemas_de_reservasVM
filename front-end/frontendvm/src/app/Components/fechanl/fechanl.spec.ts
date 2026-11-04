import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Fechanl } from './fechanl';

describe('Fechanl', () => {
  let component: Fechanl;
  let fixture: ComponentFixture<Fechanl>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Fechanl],
    }).compileComponents();

    fixture = TestBed.createComponent(Fechanl);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
