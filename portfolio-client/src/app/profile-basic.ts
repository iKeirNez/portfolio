export class OccupationBasic {

  constructor (public organisation: String, public website: String) { }

}

export class ProfileBasic {

  constructor (public location: String, public occupation: OccupationBasic) { }

}
