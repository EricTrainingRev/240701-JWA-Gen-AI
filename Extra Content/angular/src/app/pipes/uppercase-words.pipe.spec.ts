import { UppercaseWordsPipe } from './uppercase-words.pipe';

describe('UppercaseWordsPipe', () => {
  it('create an instance', () => {
    const pipe = new UppercaseWordsPipe();
    expect(pipe).toBeTruthy();
  });
});
