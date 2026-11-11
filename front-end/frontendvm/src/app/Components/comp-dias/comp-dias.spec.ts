import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CompDias } from './comp-dias';

describe('CompDias', () => {
  let component: CompDias;
  let fixture: ComponentFixture<CompDias>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CompDias],
    }).compileComponents();

    fixture = TestBed.createComponent(CompDias);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
