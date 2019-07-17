import { MarketTaBullsPage } from './app.po';

describe('market-ta-bulls App', function() {
  let page: MarketTaBullsPage;

  beforeEach(() => {
    page = new MarketTaBullsPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
