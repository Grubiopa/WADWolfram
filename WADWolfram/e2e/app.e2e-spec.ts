import { WADWolframAngularPage } from './app.po';

describe('wadwolfram-angular App', () => {
  let page: WADWolframAngularPage;

  beforeEach(() => {
    page = new WADWolframAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
