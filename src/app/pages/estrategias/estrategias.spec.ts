import { ComponentFixture, TestBed } from '@angular/core/testing';
import { Estrategias } from './estrategias';

describe('Estrategias', () => {
  let component: Estrategias;
  let fixture: ComponentFixture<Estrategias>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Estrategias],
    }).compileComponents();

    fixture = TestBed.createComponent(Estrategias);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
