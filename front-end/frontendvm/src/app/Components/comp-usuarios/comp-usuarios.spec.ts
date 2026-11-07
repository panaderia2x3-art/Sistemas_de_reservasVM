import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CompUsuarios } from './comp-usuarios';

describe('CompUsuarios', () => {
  let component: CompUsuarios;
  let fixture: ComponentFixture<CompUsuarios>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompUsuarios],
    }).compileComponents();

    fixture = TestBed.createComponent(CompUsuarios);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
