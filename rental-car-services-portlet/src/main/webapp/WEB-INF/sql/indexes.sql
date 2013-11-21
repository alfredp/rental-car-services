create index IX_6AC0080B on RC_Car (brand);
create index IX_ABAC572D on RC_Car (model);
create index IX_5D611548 on RC_Car (uuid_);
create unique index IX_7D33D062 on RC_Car (uuid_, groupId);