import { MarkeTaBullsPage } from './app.po';

describe('marke-ta-bulls App', function() {
  let page: MarkeTaBullsPage;

  beforeEach(() => {
    page = new MarkeTaBullsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
